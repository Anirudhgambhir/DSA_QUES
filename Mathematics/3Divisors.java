QUES: https://practice.geeksforgeeks.org/batch-problems/exactly-3-divisors/0/?track=DSASP-Mathematics&batchId=154#

//A number can have 3 divisors only if it is a perfect square of a number

boolean isPrime(int n)
    {
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        
        for (int i = 5; i <= Math.sqrt(n); i = i+6)
        {
            if(n%i == 0 || n%(i+2)==0)
                return false;
        }
        return true;
    }
    
    public int exactly3Divisors(int N)
    {
       int count = 0;
        for(int i = 2; i <= Math.sqrt(N); i++ ){
         
            if(isPrime(i))
            {
                count++;
            }
        }
         return count;
    }
