Jump Game II is a beautiful little puzzle about leaping across an array like a frog that refuses unnecessary hops.

Problem essence:
You are given an array nums, where each nums[i] tells you the maximum distance you can jump forward from index i. Start at index 0. Reach the last index using the minimum number of jumps.

Greedy strategy:
Instead of trying all paths or using DP recursion (slow and dramatic), notice a clever greedy trick:
At any position, you don’t actually care where you jump next exactly. You only care how far your current jump range can take you.

So you walk through the array while maintaining:
current_end → the farthest index you can reach with the current number of jumps.
farthest → the farthest you can possibly reach by considering all choices inside the current range.

When your index reaches current_end, that means you’ve exhausted all reachable options from the current jump and must jump again. At that moment, update:
jump++
current_end = farthest

Concrete example:
nums = [2, 3, 1, 1, 4]

Start:
index = 0
jump = 0
current_end = 0
farthest = 0

i = 0:
farthest = max(0, i + nums[i]) = max(0, 0 + 2) = 2
end reached? yes (i == current_end)
jump = 1
current_end = farthest = 2

i = 1:
farthest = max(2, 1 + 3) = 4

i = 2:
farthest = max(4, 2 + 1) = 4
end reached again? yes (i == current_end)
jump = 2
current_end = 4

We reached the last index. Answer = 2 jumps.

Greedy explanation in a natural metaphor:
Imagine standing in a room with many doors leading forward. For each step you take, you peek at how many rooms you can potentially reach from this spot. You don’t step through any door yet, just evaluate potential. When you reach the limit of the rooms available from your previous step, you commit to the best door (the one offering maximum range). That is one jump.

Time complexity: O(n)
Space complexity: O(1)

Greedy code:

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}


Why greedy works:
Because each time you pick a jump boundary, you’re choosing the spot that gives the largest potential reach. That guarantees minimal jumps—there’s no reason to jump smaller if a longer range is available.

Next challenge:
Try dry-running this logic on tricky cases like:
[1,1,1,1,1]
[5,4,3,2,1,0,1]
[3,4,3,2,5,4,3]

The pattern becomes clear like gears in a watch mechanism.

Tell me if you want me to walk through another example step-by-step with visuals.
