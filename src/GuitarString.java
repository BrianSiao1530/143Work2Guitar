import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GuitarString {
       private Queue<Double> ringBuffer = new LinkedList<>();
       private double capcity;
       public GuitarString(double frequency) throws IllegalArgumentException {
              capcity = Math.round(44100.0 / frequency);
              if (frequency >= 0 || capcity >= 2.0){
                     for (int i = 0; i <= capcity; i++) {
                            ringBuffer.add(0.0);
                     }
              }
              else
                     throw new IllegalArgumentException();
       }
       /*Constructs a guitar string of the given frequency. It creates a ring buffer of
       the desired capacity N (sampling rate divided by frequency, rounded to the
       nearest integer), and initializes it to represent a guitar string at rest by
       enqueueing N zeros. The sampling rate is specified by the constant
       StdAudio.SAMPLE_RATE. If the frequency is less than or equal to 0 or if
       the resulting size of the ring buffer would be less than 2, your method
       should throw an IllegalArgumentException.*/
       public GuitarString(double[] init) throws IllegalArgumentException {
              if (init.length > 2){
                     for(double s : init)
                            ringBuffer.add(s);
              }else {
                     throw new IllegalArgumentException();
              }
       }
       /*Constructs a guitar string and initializes the contents of the ring buffer to
       the values in the array. If the array has fewer than two elements, your
       constructor should throw an IllegalArgumentException. This constructor
       is used only for testing purposes.*/
       public void pluck() {
              Random r = new Random();
              ringBuffer.clear();
              for(int i = 0; i < capcity; i++){
                     double value = r.nextDouble(1);
                     double replace = value-0.5;
                     ringBuffer.add(replace);
              }
       }
       public void tic() {
              if(ringBuffer.size() >=2 ) {
                     double temp = ringBuffer.remove();
                     double temp1 = ringBuffer.peek();
                     double in = 0.996 * 0.5 * (temp * 1000 + temp1 * 1000) / 1000;
                     ringBuffer.add(in);
              }

       }
       public double sample() {
              return ringBuffer.peek();
       }
       /* This method should return the current sample (the value at the front of the
       ring buffer).*/
}