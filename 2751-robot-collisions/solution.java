class Solution {
    public static class Tuple {
        private int health;
        private int position;
        private char direction;
        private int index;

        public Tuple(int health, int position, char direction, int index) {
            this.health = health;
            this.position = position;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Tuple> list = new ArrayList<>();
        int n = positions.length;
        for (int i = 0; i < n; i++) {
            list.add(new Tuple(healths[i], positions[i], directions.charAt(i), i));
        }
        list.sort(Comparator.comparingInt(a -> a.position));
        ArrayDeque<Tuple> stack = new ArrayDeque<>();
        int i = 0;
        while (i < n) {
            Tuple t = list.get(i++);
            if (stack.isEmpty()) {
                stack.push(t);
                continue;
            }
            while (!stack.isEmpty() && t != null && stack.peek().direction == 'R' && t.direction == 'L') {
                if (stack.peek().health == t.health) {
                    stack.pop();
                    t = null;
                } else if (stack.peek().health > t.health) {
                    Tuple top = stack.pop();
                    top.health--;
                    stack.push(top);
                    t = null;
                } else {
                    stack.pop();
                    t.health--;
                }
            }
            if (t != null) {
                stack.push(t);
            }
        }
        List<Tuple> h = new ArrayList<>();
        while (!stack.isEmpty()) {
            h.add(stack.pop());
        }
        h.sort(Comparator.comparingInt(a -> a.index));
        return h.stream().map(tuple -> tuple.health).collect(Collectors.toList());
    }
}