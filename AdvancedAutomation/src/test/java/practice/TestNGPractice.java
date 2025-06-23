package practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	

		@Test(invocationCount = 0)

		
		public void create()

		{

		System.out.println("create");

		}

		@Test
        public void modify()

		{

			System.out.println("modify");
		}


	

		@Test

		public void delete()

		{
			System.out.println("delete");
		}
}
