// skeleton version of the class

public class Guitar37 implements Guitar {
   public int times = 0;
   public static final String KEYBOARD =
           "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   private final GuitarString[] AllString = new GuitarString[37];


   public Guitar37() {
      for (int i = -24; i <= 12 ; i++) {
         int num = i +24;
         double concerC = 440.0 * Math.pow(2, (double) i / 12.0);
         AllString[num] = new GuitarString(concerC);
      }
   }
   public void playNote(int pitch) {
      for (int i = -24; i <= 12; i++) {
         int num = i + 24;
         if (pitch == i){
            AllString[num].pluck();
         }
      }
   }
   public boolean hasString(char key) {
      boolean exist = false ;
      for (int i = 0; i < 37; i++) {
         exist = (exist || key == KEYBOARD.charAt(i));
      }
      return exist;
   }
   public void pluck(char key) {
      for (int i = 0; i < 37; i++) {
         if (key == KEYBOARD.charAt(i)){
            AllString[i].pluck();
         }
      }
   }
   public double sample() {
      double sum = 0;
      for (int i = 0; i < 37; i++) {
         sum = sum + AllString[i].sample();
      }
      return sum;
   }
   public void tic() {
      for (int i = 0; i < 37; i++) {
         AllString[i].tic();
      }
      times++;
   }
   public int time(){
      {
         return times;
         // not implemented
      }
   }
}
