class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        return (Robot.robotSim2(commands, obstacles));
    }
    static class Robot{
        public static int robotSim2(int[] commands, int[][] obstacles) {
            int[] resultAxis = new int[]{0,0};
            int maxEvklid = 0;
            Set<Integer> obtaclesSet = new HashSet<>();
            for(int[] ob : obstacles){
                obtaclesSet.add(hashCode(ob));
            }
            int currentAxis = 1;
            int coefficient = 1;
            for(int command : commands){
                if(command < 0) {
                    if(
                            (coefficient == -1 && currentAxis == 0 && command == -2) ||
                            (coefficient == -1 && currentAxis == 1 && command == -1) ||
                            (coefficient == 1 && currentAxis == 1 && command == -2) ||
                            (coefficient == 1 && currentAxis == 0 && command == -1)){

                        coefficient = -1;
                    } else coefficient = 1;
                    currentAxis = 1 - currentAxis;
                } else {
                    for(int i = 0; i < command; i++){
                        resultAxis[currentAxis]+=coefficient;
                        if(obtaclesSet.contains(hashCode(resultAxis))) {
                            resultAxis[currentAxis]-=coefficient;
                            break;
                        }
                    }
                    int evklidToCheck = evklid(resultAxis);
                    maxEvklid = (maxEvklid > evklidToCheck) ? maxEvklid : evklidToCheck;
                }
            }
            return maxEvklid;
        }

        private static int evklid(int[] nums){
            return nums[0]*nums[0] + nums[1]*nums[1];
        }
        private static Integer hashCode(int[] list){
            return Arrays.toString(list).hashCode();
        }
    }
}