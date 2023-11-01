import com.example.Feline;
import com.example.Lion;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void maleHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);

        MatcherAssert.assertThat(lion.doesHaveMane(), CoreMatchers.is(true));
    }

    @Test
    public void femaleHasNotMane() throws Exception {
        Lion lion = new Lion("Самка", feline);

        MatcherAssert.assertThat(lion.doesHaveMane(), CoreMatchers.is(false));
    }

    @Test
    public void exceptionOnWrongSex() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");

        new Lion("", feline);
    }

    @Test
    public void getKittensAsFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);

        when(feline.getKittens()).thenReturn(3);

        MatcherAssert.assertThat(lion.getKittens(), CoreMatchers.is(3));
    }

    @Test
    public void getFoodFromFelineAsPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);

        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));

        MatcherAssert.assertThat(
                lion.getFood(),
                CoreMatchers.hasItems("Животные", "Птицы")
        );
    }
}
