public abstract class FundCalculations {
    protected int currentBudget;
    
    public FundCalculations(){
        currentBudget =0;
    }

    protected int getArraySum(int[] arr){
        int sum=0;
        for(int i=0; i<arr.length(); i++){
            sum+=arr[i];
        }
        return sum;
    }
}
