package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class GiftCardTest
{
    @Test
    public void getIssuingStore()
    {
        double       balance;        
        GiftCard     card;
        int          issuingStore;
        
        issuingStore = 1337;
        balance      = 100.00;
        card = new GiftCard(issuingStore, balance);

        assertEquals("getIssuingStore()", 
                     issuingStore, card.getIssuingStore());

    }


	@Test
	public void getBalance()
	{
	    double       balance;        
	    GiftCard     card;
	    int          issuingStore;
	    
	    issuingStore = 1337;
	    balance      = 100.00;
	    
	    card = new GiftCard(issuingStore, balance);
	    
	    assertEquals("getBalance()", balance, card.getBalance(), .001);
	}
	
	@Test
	public void deduct_RemainingBalance() {
	    double	balance;        
	    GiftCard	card;
	    int	issuingStore;
	    String 	test;
	    issuingStore = 1337;
	    balance      = 100.00;
	    card = new GiftCard(issuingStore, balance);
	    
	    test = "Remaining Balance: " + String.format("%6.2f", 0.00);
	    
	    assertEquals("deduct_RemainingBalance()", test, card.deduct(100));
	}
	
	@Test
	public void deduct_NegativeAmount() {
	    double	balance;        
	    GiftCard	card;
	    int	issuingStore;
	    String 	test;
	    issuingStore = 1337;
	    balance      = 100.00;
	    card = new GiftCard(issuingStore, balance);
	    
	    test = "Invalid Transaction";
	    
	    assertEquals("deduct_NegativeAmount()", test, card.deduct(-1));
	}
	
	@Test
	public void deduct_NegativeBalance() {
	    double	balance;        
	    GiftCard	card;
	    int	issuingStore;
	    String 	test;
	    issuingStore = 1337;
	    balance      = 100.00;
	    card = new GiftCard(issuingStore, balance);
	    
	    test = "Amount Due: " + String.format("%6.2f", 10.00);
	    
	    assertEquals("deduct_NegativeBalance()", test, card.deduct(110));
	}
	
	@Test
	public void constructorIOpeningBalance_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructorIncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
	}
	
	@Test
	public void constructorIncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});
	}
}
