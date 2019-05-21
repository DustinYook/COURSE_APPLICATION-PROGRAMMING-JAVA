package class06;

public class Test // 중간고사에 내기 딱 좋으니 반드시 확실히 이해할 것!
{
	public static void main(String[] args) 
	{
		/** Member Fields */
		A var1 = new A(); // normal
		A var2 = new B(); // polymorphism
		B var3 = new D(); // polymorphism
		C var4 = new C(); // normal
		D var5 = new D(); // normal
		Object var6 = new B();
		
		/** Methods are called here, guess the output */
		
		/** for method1 */
//		var1.method1(); // A1
//		var2.method1(); // B1, A1 (method of class B)
//		var3.method1(); // B1, A1 (method of class B)
//		var4.method1(); // B1, A1 (method of class B)
//		var5.method1(); // B1, A1 (method of class B)
//		var6.method1(); // compile error (Object에 method1이 존재하지 않음)
		
		/** for method2 */
//		var1.method2(); // A1, A2
//		var2.method2(); // B1, A1, A2 (A.method1 -> this.method1 -> "B1" -> super.method1 -> "A1" -> "A2")
//		var3.method2(); // C2, D2 (super.method2 -> "C2" -> "D2")
//		var4.method2(); // C2 
//		var5.method2(); // C2, D2 (super.method2 -> "C2" -> "D2")
//		var6.method2(); // compile error (Object에 method1이 존재하지 않음)
		
		/** for method3 */
//		var1.method3(); // compile error (A에 method3가 존재하지 않음)
//		var3.method3(); // compile error (B에 method3가 존재하지 않음)
//		var6.method3(); // compile error (Object에 method3가 존재하지 않음)
		/** 주의) Parent child = new Child();에서 최소한 Parent에 호출하고자 하는 메소드가 존재해야 한다! */
//		var5.method3(); // B1, A1, C3 (C.method3 -> super.method1 -> "B1" -> super.method1 -> "A1" -> "C3")
		
		/** down-casting이 불가능한 사례 */
//		((B)var1).method1(); // runtime error (A를 B로 down-casting 불가)
//		((C)var2).method2(); // runtime error (B를 C로 down-casting 불가)
//		((D)var4).method3(); // runtime error (C를 D로 down-casting 불가)
//		((C)var6).method3(); // runtime error (Object안에는 B가 들어있어 더 작은 C로 down-casting 불가)
		
		/** down-casting이 가능한 사례 */
//		((B)var2).method1(); // B1, A1 
//		((B)var2).method2(); // B1, A1, A2 (A.method2 -> this.method1 -> "B1" -> super.method1 -> "A1" -> "A2")
//		((C)var3).method3(); // B1, A1, C3 (C.method3 -> super.method1 -> "B1" -> super.method1 -> "A1" -> "C3")
		// var3는 B타입 -> 더 작은 C타입으로 down-casting하지만 실제로 var3에는 D타입이 들어있어 truncate가 발생하지 않음 (문제없이 down-casting 가능)
//		((B)var6).method1(); // B1, A1 (Object를 B로 down-casting해서 B에 들어있는 method1을 호출)

		/** down-casting이 아닌 사례 */
//		((D)var5).method1(); // B1, A1 (down-casting 아님)
	}
}