
MomentumBees
2 weeks ago
I added a check for if the no of unique chars in the string is less than the k..  for example Str=aaabe k =4

HashMap<Character,Integer> charMap=new HashMap<>();
            int i =0;
            int j =0;
            int maxStringlen = Integer.MIN_VALUE;
            while(j<s.length()){
                char ch=s.charAt(j);
                charMap.put(ch, charMap.getOrDefault(ch, 0)+1);

                if(charMap.size()<k){
                    j++;
                }
                else if(charMap.size()==k){
                    maxStringlen=Math.max(maxStringlen,j-i+1);
                    j++;
                }
                else if(charMap.size()>k ){
                    while(charMap.size()>k){

                        if(charMap.containsKey(s.charAt(i))){
                            int freq=charMap.get(s.charAt(i));
                            freq--;
                            charMap.put(s.charAt(i),freq);
                        }
                        if(charMap.get(s.charAt(i))==0){
                            charMap.remove(s.charAt(i));
                        }
                        i++;
                    }
                    j++;
                }
            }
            System.out.println("The no of unique chars are : " + charMap.size());
            return (charMap.size()<k)? 0: maxStringlen;
