// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		} else {
			// אם x2 שלילי, אנו מחסרים את הערך המוחלט של x2
			int absX2 = minus(0, x2);
			for (int i = 0; i < absX2; i++) {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		} else {
			// אם x2 שלילי, אנו מוסיפים את הערך המוחלט של x2
			int absX2 = minus(0, x2);
			for (int i = 0; i < absX2; i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0;
		}

		boolean negativeResult = (x1 < 0) != (x2 < 0);

		// עבודה עם הערכים המוחלטים
		int absX1 = (x1 < 0) ? minus(0, x1) : x1;
		int absX2 = (x2 < 0) ? minus(0, x2) : x2;

		int Counter = 0;
		for (int i = 0; i < absX2; i++) {
			Counter = plus(Counter, absX1);
		}

		return negativeResult ? minus(0, Counter) : Counter;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (x == 0) {
			return 0;
		}

		// טיפול בבסיס שלילי (Test 6)
		boolean isBaseNegative = x < 0;
		boolean isExponentOdd = mod(n, 2) != 0;
		boolean negativeResult = isBaseNegative && isExponentOdd;

		// עבודה עם הערך המוחלט של הבסיס
		int absX = isBaseNegative ? minus(0, x) : x;

		int Counter = 1;

		for (int i = 0; i < n; i++) {
			Counter = times(Counter, absX);
		}

		return negativeResult ? minus(0, Counter) : Counter;
	}

	// Returns the integer part of x1 / x2 - משתמש ב-if-else מפורש כפי שביקשת
	public static int div(int x1, int x2) {
		if (x2 == 0) {
			return 0;
		}
		if (x1 == 0) {
			return 0;
		}

		boolean negativeResult = (x1 < 0) != (x2 < 0);

		int absX1;
		if (x1 < 0) {
			absX1 = minus(0, x1);
		} else {
			absX1 = x1;
		}

		int absX2;
		if (x2 < 0) {
			absX2 = minus(0, x2);
		} else {
			absX2 = x2;
		}

		int quotient = 0;
		int tempX1 = absX1;

		while (tempX1 >= absX2) {
			tempX1 = minus(tempX1, absX2);
			quotient++;
		}

		if (negativeResult) {
			return minus(0, quotient);
		} else {
			return quotient;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) {
			return 0;
		}

		int x = div(x1, x2);
		int product = times(x2, x);
		int remainder = minus(x1, product);

		return remainder;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		if (x < 0) {
			return 0;
		}

		int n = 0;
		while (true) {
			int next_n = plus(n, 1);
			int next_n_squared = times(next_n, next_n);

			if (next_n_squared > x) {
				break;
			}
			n = next_n;
		}

		return n;
	}
}
