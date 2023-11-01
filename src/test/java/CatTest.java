import com.example.Cat;
import com.example.Feline;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Feline feline;

    @Test
    public void catSoundMau() {
        Cat cat = new Cat(feline);

        MatcherAssert.assertThat(cat.getSound(), CoreMatchers.is("Мяу"));
    }

    @Test
    public void catEatMeat() throws Exception {
        Cat cat = new Cat(feline);

        MatcherAssert.assertThat(
                cat.getFood(),
                CoreMatchers.hasItems("Животные", "Птицы", "Рыба")
        );
    }

    @Test
    public void getFoodFromFeline() throws Exception {
        Cat cat = new Cat(feline);

        cat.getFood();

        verify(feline).eatMeat();
    }
}
