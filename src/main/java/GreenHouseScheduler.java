import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 温室控制器
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/8/5
 */
public class GreenHouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public void setThermostat(String value) {
        thermostat = value;
    }

    ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MICROSECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MICROSECONDS);
    }

    class LightOn implements Runnable {

        public void run() {
            System.out.println("Turn Light On");
            light = true;
        }
    }

    class LightOff implements Runnable {
        public void run() {
            System.out.println("Turn light Off");
            light = false;
        }
    }

    class WaterOn implements Runnable {
        public void run() {
            System.out.println("Turn GreenHouse Water ON");
            water = true;
        }
    }

    class WaterOff implements Runnable {

        public void run() {
            System.out.println("Turn greenHouse Water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        public void run() {
            System.out.println("Thermostat night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        public void run() {
            System.out.println("Thermostat day setting");
            setThermostat("Days");
        }
    }

    class Bell implements Runnable {
        public void run() {
            System.out.println("belling");
        }
    }

    class Terminate implements Runnable {
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
            new Thread() {
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;

        }

        public String toString() {
            return time.getTime() + String.format(" temperature: %1$.1f humidity:%2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.SECOND, 30);
        lastTime.set(Calendar.MINUTE, 30);
    }

    private float lastTemp = 0;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private float humidityDirection = +1;
    private Random random = new Random(47);

    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

    class CollectionData implements Runnable {
        public void run() {
            System.out.println("Collect data");
            synchronized (GreenHouseScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                if (random.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection * (1.0f + random.nextFloat());
                if (random.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * random.nextFloat();
                data.add(new DataPoint((Calendar) lastTime.getTime().clone(), lastTemp, lastHumidity));
            }

        }
    }

    public static void main(String[] args) {
        GreenHouseScheduler gh = new GreenHouseScheduler();
        gh.schedule(gh.new Terminate(), 50000);
        gh.repeat(gh.new Bell(), 0, 100);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOff(), 0, 800);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new CollectionData(), 500, 500);
    }
}
