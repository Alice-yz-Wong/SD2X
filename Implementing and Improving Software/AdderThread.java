package Implementing and Improving Software;

public class AdderThread extends Thread{
    private int[] arr;
    private int sum;

    public void MyThread(int[] arr){
        this.arr=arr;
    }

    public void run(){
        for (int i=0; i<arr.length;i++){
            sum+=arr[i];
        }
    }

    public int getSum(){
        return sum;
    }

    public int addArray(int[] arr){
        int midpoint=arr.length/2;

        //split arr in half
        int[] firstHalf=arr.copyOfRange(arr,0,midpoint);
        int[] secondHalf=arr.copyOfRange(arr,midpoint,arr.length);

        AdderThread firstAdder= new AdderThread(firstHalf);
        AdderThread secondAdder= new AdderThread(firstHalf);

        firstAdder.start();
        secondAdder.start();

        firstAdder.join();
        secondAdder.join();

        int firstSum=firstAdder.getSum();
        int secondSum=secondAdder.getSum();

        return firstSum + secondSum;


    }
}
