package timeadekany.blackjack.card;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import timeadekany.blackjack.game.OutPutWriter;
import timeadekany.blackjack.game.UserInputReader;
import timeadekany.blackjack.wrappings.MyScanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public final class UserInputReaderTest {

	private static final Integer VALID_INPUT_NUMBER = 500;
	private static final Integer INVALID_INPUT_NEGATIVE_NUMBER = -1;
	private static final Integer INVALID_0_NUMBER = 0;
	private static final String INVALID_INPUT_STRING_CHARACTER = "";
	private static final String INVALID_MENU_CHARACTER = "a";
	private static final String LOWERCASE_QUIT_CHARACTER = "q";
	private static final String UPPERCASE_QUIT_CHARACTER = "Q";

	@Test
	public void testReadingUserInputInt(){
		MyScanner mockedScan = Mockito.mock(MyScanner.class);
		OutPutWriter mockedWriter = Mockito.mock(OutPutWriter.class);
		Mockito.when(mockedScan.nextLine()).thenReturn(VALID_INPUT_NUMBER.toString());
		UserInputReader userInputReader = new UserInputReader(mockedScan, mockedWriter);
		Integer userEnteredInt = userInputReader.readUserInputInt();
		Assert.assertEquals(VALID_INPUT_NUMBER, userEnteredInt);
	}

	@Test
	public void testReadingInvalidStringUserInput(){
		MyScanner mockedScan = Mockito.mock(MyScanner.class);
		OutPutWriter mockedWriter = Mockito.mock(OutPutWriter.class);
		Mockito.when(mockedScan.nextLine()).thenReturn("alma",VALID_INPUT_NUMBER.toString());
		UserInputReader userInputReader = new UserInputReader(mockedScan, mockedWriter);
		Integer userEnteredInt = userInputReader.readUserInputInt();
		Assert.assertEquals(VALID_INPUT_NUMBER, userEnteredInt);
	}

	@Test
	public void testValidUserChoiceAcceptable(){
		UserInputReader userInputReader = new UserInputReader();
		assertTrue(userInputReader.userChoiceAcceptable("H"));
		assertTrue(userInputReader.userChoiceAcceptable("h"));
		assertTrue(userInputReader.userChoiceAcceptable("S"));
		assertTrue(userInputReader.userChoiceAcceptable("s"));
		assertTrue(userInputReader.userChoiceAcceptable("Q"));
		assertTrue(userInputReader.userChoiceAcceptable("q"));
	}

	@Test
	public void testInValidUserChoiceAcceptable(){
		UserInputReader userInputReader = new UserInputReader();
		assertFalse(userInputReader.userChoiceAcceptable("K"));
		assertFalse(userInputReader.userChoiceAcceptable("k"));
		assertFalse(userInputReader.userChoiceAcceptable("0"));
		assertFalse(userInputReader.userChoiceAcceptable("-"));
		assertFalse(userInputReader.userChoiceAcceptable("null"));
	}

	@Test
	public void testReadingValidMenuItem(){
		MyScanner mockedScan = Mockito.mock(MyScanner.class);
		OutPutWriter mockedWriter = Mockito.mock(OutPutWriter.class);
		Mockito.when(mockedScan.nextLine()).thenReturn(LOWERCASE_QUIT_CHARACTER);
		UserInputReader userInputReader = new UserInputReader(mockedScan, mockedWriter);
		String userEnteredCharacter = userInputReader.readMenuCharacter();
		Assert.assertEquals(UPPERCASE_QUIT_CHARACTER, userEnteredCharacter);
		Mockito.verify(mockedScan, Mockito.times(1)).nextLine();
		Mockito.verify(mockedWriter, Mockito.times(1)).writerUserChoice();
	}

	@Test
	public void testReadingValidMenuItemForSecondTry(){
		MyScanner mockedScan = Mockito.mock(MyScanner.class);
		OutPutWriter mockedWriter = Mockito.mock(OutPutWriter.class);
		Mockito.when(mockedScan.nextLine()).thenReturn(INVALID_MENU_CHARACTER, LOWERCASE_QUIT_CHARACTER);
		UserInputReader userInputReader = new UserInputReader(mockedScan, mockedWriter);
		String userEnteredCharacter = userInputReader.readMenuCharacter();
		Assert.assertEquals(UPPERCASE_QUIT_CHARACTER, userEnteredCharacter);
		Mockito.verify(mockedScan, Mockito.times(2)).nextLine();
		Mockito.verify(mockedWriter, Mockito.times(2)).writerUserChoice();
	}
}
