import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ScrapeTest {

    static String poem;


    @BeforeClass
    public static void getMapOfWords() {
        Scrape scrape = new Scrape();
        poem = Scrape.getPeomWords();
    }

    @Test
    public void testWordThe() {
        int n = getStringCountInPoem("the");
        Assert.assertEquals(n, 56);
    }

    @Test
    public void testWordAnd() {
        int n = getStringCountInPoem("And");
        Assert.assertEquals(n, 8);
    }

    @Test
    public void testWordThy() {
        int n = getStringCountInPoem("thy");
        Assert.assertEquals(n, 7);
    }

    @Test
    public void testWordRaven() {
        int n = getStringCountInPoem("Raven");
        Assert.assertEquals(n, 10);
    }

    @Test
    public void testWordNevermore() {
        int n = getStringCountInPoem("Nevermore");
        Assert.assertEquals(n, 8);
    }

    @Test
    public void testWordChamber() {
        int n = getStringCountInPoem("chamber");
        Assert.assertEquals(n, 11);
    }

    @Test
    public void testWordDoor() {
        int n = getStringCountInPoem("door");
        Assert.assertEquals(n, 14);
    }

    @Test
    public void testWordLenore() {
        int n = getStringCountInPoem("Lenore");
        Assert.assertEquals(n, 8);
    }



    public int getStringCountInPoem(String s) {
        for (String k : poem.split("\n")) {
            if (k.contains(s)) {
                return Integer.parseInt(k.split(" ")[0]);
            }
        }
        return 0;
    }
}