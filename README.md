# izzo

## Method Summaries

### isEmpty():
Runtime: O(1) Constant time

### add()
Runtime: O(1) Amortized constant time
This method adds the String to the end of the ArrayList making it constant time. However, it is amortized because the ArrayList will need to expand occassionally.

### peekMin()
Runtime: O(n) Linear time
This method will iterate through the entire Arraylist to find the String that is closest to the start of the alphabet making it linear time.

### removeMin()
Runtime: O(n) Linear time
This method will iterate through the entire ArrayList to find where the String that is closest to the start of the alphabet is. Then it will remove that String. Both processes are linear time making the method run in linear time.
### Heap Todo
- [x] `isEmpty()`
- [x] `add( Integer addVal )`
- [x] `peekMin()`
- [x] `removeMin()`
- [x] `toString()`
