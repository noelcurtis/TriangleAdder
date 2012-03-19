### Build

This project is built with Maven.

### Test

This project is tested with JUnit.

### Usage

<pre>
	// First parse the input file.
	TriangleAdder.getInstance().parseFile("data/test1.txt");
	// Find the largest sum.
    long largestSum = TriangleAdder.getInstance().findLargestSum();
</pre>