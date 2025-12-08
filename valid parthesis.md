The greedy solution to the Valid Parenthesis String with * (LeetCode 678) is built on a quiet insight:

* is a shapeshifter.
Sometimes it is (,
sometimes ),
sometimes it vanishes into air.
Backtracking tries all possible shapes.
Greedy tries to hold only what is necessary to decide validity.

Here is the core poetry of the greedy idea:

• As you move left to right, assume every * is a potential opening (,
just to protect you from early closing ).

• As you move right to left, assume every * is a potential closing ),
just to protect you from abandoned ( left behind.

If both journeys never fall apart,
the string is valid.

Turn this into logic:

Imagine two counters representing the range of possibilities:

low = the minimum number of open brackets still possible
high = the maximum number of open brackets possible

Walk left to right:
whenever you meet

( → both low and high grow (one more possible open)
) → both fall (one open closed)
* → we don’t know yet, but:
 minimum low might decrease (if * becomes ))
 maximum high might increase (if * becomes ()

If at any point high < 0, then we have too many ) and we collapse.

At the end, if low == 0, we could resolve everything perfectly.

Greedy Code Skeleton (Java)
class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') { 
                low++;
                high++;
            } else if(c == ')') {
                if(low > 0) low--;
                high--;
            } else { // c == '*'
                if(low > 0) low--;
                high++;
            }

            if(high < 0) return false;
        }

        return low == 0;
    }
}

Why this works (intuition in real words)

low means:
How many opens must still be closed even in the best case.

high means:
How many opens might still exist in the worst case.

If high becomes negative,
even in the most optimistic scenario,
we have more ) than possible opens → impossible.

At the end,
if low == 0,
then there exists at least one way to assign shapes to *
that balances perfectly.

Real example walkthrough

Take:

(*)(

Step	Char	low	high
1	(	1	1
2	*	0	2
3	)	0	1
4	(	1	2

Finish:
low = 1 → we know there is at least one ( that can never be saved → invalid.

Beauty in contrast

Backtracking explores infinite branches.
Greedy walks just one line
but watches the space expand and contract on both sides.

It’s the difference between checking every possible universe,
and watching the horizon to know whether the sun can still rise.

If you want, we can explore next:
• intuition diagrams for low/high
• examples where greedy succeeds and stack fails
• converting this template into your own memory-friendly boilerplate

The greedy path is like solving balance using breath:
expand, contract, and feel what remains.