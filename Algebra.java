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

		for (int i = 0; i < x2; i++) {

			x1++;

		}

		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		for (int i = 0; i < x2; i++) {

			x1--;

		}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		int Counter = 0;

		for (int i = 0; i < x2; i++) {
			Counter = plus(Counter, x1);
		}

		return Counter;

	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		if (n < 0) {
			// עבור Int, התוצאה היא שבר. נחזיר 0 כפי שמומלץ למגבלות אלו.
			return 0;
		}

		// 2. טיפול במקרה של חזקת אפס (כל מספר בחזקת 0 הוא 1)
		if (n == 0) {
			return 1;
		}

		// 3. טיפול במקרה של 0 בחזקת כל מספר חיובי (0^n = 0)
		if (x == 0) {
			return 0;
		}

		int Counter = 1;

		for (int i = 0; i < n; i++) {

			Counter = times(Counter, x);
		}

		return Counter;

	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		if (x2 == 0) {
			return 0; // טיפול בחלוקה באפס
		}
		if (x1 == 0) {
			return 0;
		}

		// 1. קביעת סימן התוצאה: אם הסימנים שונים, התוצאה שלילית
		boolean negativeResult = (x1 < 0) != (x2 < 0);

		// 2. עבודה עם הערכים המוחלטים (באמצעות minus)
		int absX1;
		if (x1 < 0) {
			absX1 = minus(0, x1); // minus(0, x1) הוא -x1
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

		// 3. חיסור חוזר על הערכים המוחלטים
		while (tempX1 >= absX2) {
			tempX1 = minus(tempX1, absX2);
			quotient++;
		}

		// 4. החזרת התוצאה עם הסימן הנכון (באמצעות if-else מפורש)
		if (negativeResult) {
			// אם התוצאה צריכה להיות שלילית, הפוך את הסימן
			return minus(0, quotient);
		} else {
			// אחרת, החזר את המנה החיובית שחושבה
			return quotient;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {

		int sum = 0;
		int fsum = 0;

		if (x2 != 0) {

			int x = div(x1, x2);
			sum = times(x2, x);
			fsum = minus(x1, sum);
		} else {
			return 0;
		}

		return fsum;

	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {

		int sum = 0;
		int n = 0;

		while (x >= sum) {
			n++;
			sum = times(n, n);

		}

		return n - 1;

	}
}