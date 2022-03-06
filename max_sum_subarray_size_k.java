// write your code here
        int i=0,j=0;
        int sum=0;
        int maxk=Integer.MIN_VALUE;
        while(j<arr.length){
            sum=sum+arr[i];
            if(j-i+1<k)
                j++;
            else if(j-i+1 == k){
                maxk=Math.max(maxk,sum);
                sum=sum-arr[i];
                i++;
                j++;
            }
        }
        
        return maxk;
