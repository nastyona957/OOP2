package ru.netology.stats;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int numberOfStations;

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this.numberOfStations = 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    // Конструктор с указанием количества станций
    public Radio(int numberOfStations) {
        if (numberOfStations > 0) {
            this.numberOfStations = numberOfStations;
        } else {
            this.numberOfStations = 10;
        }
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < numberOfStations) {
            this.currentStation = currentStation;
        }
    }

    public void next() {
        if (currentStation == numberOfStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = numberOfStations - 1;
        } else {
            currentStation--;
        }
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= 0 && currentVolume <= 100) {
            this.currentVolume = currentVolume;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}