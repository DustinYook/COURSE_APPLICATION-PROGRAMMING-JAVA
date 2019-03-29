package class04;

public class Main 
{
	public static void main(String[] args) 
	{
		String[] mobile = {"010-4034-1075", "010-9110-0684", "032-321-5365"};
		AddressBook myAddress = new AddressBook("YOOK DONGHYUN", 7, 11, 1993, mobile, "yookdonny3@naver.com", "Rakuten");
		System.out.println(myAddress);
		myAddress.setEmail("aomorikaitou93@gmial.com");
		System.out.println();
		System.out.println(myAddress);
	}
}