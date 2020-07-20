import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndLimit_01() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_060;
        boolean registered = true;
        long expected = 31;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoRegisteredAndLimit_02() {
        BonusService service = new BonusService();
        long amount = 1_060;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndOverLimit_03() {
        BonusService service = new BonusService();
        long amount = 18_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndOverLimit_04() {
        BonusService service = new BonusService();
        long amount = 55_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndLimitBorderline_05() {
        BonusService service = new BonusService();
        long amount = 49_999;
        boolean registered = false;
        long expected = 499;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

}