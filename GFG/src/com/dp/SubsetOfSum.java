package com.dp;

public class SubsetOfSum {

	public static void main(String [] args){
		int [] arr = {2,1,5,6,7,4};
		//System.out.println(isSubsetOfSumExist(arr,arr.length,20));
		System.out.println(isSubsetExistWithDp(arr, arr.length, 10));
	}

	private static boolean isSubsetOfSumExist(int[] arr, int n, int sum) {
		System.out.println("Arr " + arr + " n "+ n + " sum " + sum);
		if(sum == 0)
		{
			return true;
		}
		if((n == 0 && sum != 0 )|| sum < 0){
			return false;
		}
		
		return isSubsetOfSumExist(arr, n-1, sum-arr[n-1]) || isSubsetOfSumExist(arr, n-1, sum); 
	}
	
	private static boolean isSubsetExistWithDp(int [] arr, int n , int sum ){
		
		boolean [][] dp = new boolean[sum+1][n+1];
		//System.out.println(dp[][0]);
		for(int i = 0 ; i < n; i++){
			dp[0][i] = true;
		}
		System.out.println("b");
		for(int i = 1 ; i<=sum;i++)
		{
			System.out.println("d");
			for(int j = 1 ; j<=n;j++)
			{
				System.out.println("c");
				
				dp[i][j] = dp[i][j-1];
				if(i>=arr[j-1]){
					dp[i][j] = dp[i][j-1] || dp[i-arr[j-1]][j-1];
				}
			}
			
		}
		
		for(int i =1 ; i <= sum;i++)
		{
		
			for(int j = 1 ; j <= n; j++)
			{
				System.out.print(" "+ dp[i][j]);
			}
			System.out.println();
		}
		return dp[sum][n];
		
	}
}
