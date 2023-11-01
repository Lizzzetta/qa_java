import com.example.Feline;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class FelineTest {

    @Test
    public void felineFoodIsMeat() throws Exception {
        Feline feline = new Feline();

        MatcherAssert.assertThat(
                feline.eatMeat(),
                CoreMatchers.hasItems("Животные", "Птицы", "Рыба")
        );
    }

    @Test
    public void felineFamilyIsCat()
    {
        Feline feline = new Feline();

        MatcherAssert.assertThat(feline.getFamily(), CoreMatchers.is("Кошачьи"));
    }

    @Test
    public void felineDefaultKittens()
    {
        Feline feline = new Feline();

        MatcherAssert.assertThat(feline.getKittens(), CoreMatchers.is(1));
    }

    @Test
    public void felineDefinedKittens()
    {
        Feline feline = new Feline();

        MatcherAssert.assertThat(feline.getKittens(3), CoreMatchers.is(3));
    }
}
