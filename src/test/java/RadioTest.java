
import org.junit.jupiter.api.Test;
import ru.netology.stats.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    // Тесты для конструкторов
    @Test
    void constructorDefaultSetsTenStations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getNumberOfStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void constructorWithParamSetsCorrectNumberOfStations() {
        Radio radio = new Radio(25);
        assertEquals(25, radio.getNumberOfStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void constructorWithZeroStationsUsesDefault() {
        Radio radio = new Radio(0);
        assertEquals(10, radio.getNumberOfStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void constructorWithNegativeStationsUsesDefault() {
        Radio radio = new Radio(-5);
        assertEquals(10, radio.getNumberOfStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    // Тесты для установки станции
    @Test
    void setCurrentStationValidWithCustomStations() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(12);
        assertEquals(12, radio.getCurrentStation());
    }

    @Test
    void setCurrentStationInvalidAboveMaxWithCustomStations() {
        Radio radio = new Radio(5); // Максимальная станция 4
        radio.setCurrentStation(5);
        assertEquals(0, radio.getCurrentStation()); // Не должна измениться, т.к. 5 >= 5
    }

    @Test
    void setCurrentStationInvalidBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    // Тесты для переключения станций
    @Test
    void nextStationWrapsAroundWithDefaultStations() {
        Radio radio = new Radio(); // 10 станций, макс = 9
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStationNormalWithDefaultStations() {
        Radio radio = new Radio(); // 10 станций
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void nextStationWrapsAroundWithCustomStations() {
        Radio radio = new Radio(7); // 7 станций, макс = 6
        radio.setCurrentStation(6);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStationNormalWithCustomStations() {
        Radio radio = new Radio(12); // 12 станций
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevStationWrapsAroundWithDefaultStations() {
        Radio radio = new Radio(); // 10 станций
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevStationNormalWithDefaultStations() {
        Radio radio = new Radio(); // 10 станций
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void prevStationWrapsAroundWithCustomStations() {
        Radio radio = new Radio(15); // 15 станций
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(14, radio.getCurrentStation());
    }

    @Test
    void prevStationNormalWithCustomStations() {
        Radio radio = new Radio(8); // 8 станций
        radio.setCurrentStation(3);
        radio.prev();
        assertEquals(2, radio.getCurrentStation());
    }

    // Тесты для громкости
    @Test
    void increaseVolumeNormal() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeNormal() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeValid() {
        Radio radio = new Radio();
        radio.setCurrentVolume(75);
        assertEquals(75, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeInvalidAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume()); // Не должна измениться
    }

    @Test
    void setCurrentVolumeInvalidBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-5);
        assertEquals(0, radio.getCurrentVolume()); // Не должна измениться
    }
}