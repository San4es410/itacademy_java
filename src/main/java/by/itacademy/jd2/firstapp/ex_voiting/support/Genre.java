package by.itacademy.jd2.firstapp.ex_voiting.support;

public class Genre {
    private String name;
    private int numberVotes;

    public Genre(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getNumberVotes() {

        return numberVotes;
    }

    public void setNumberVotes(int numberVotes) {

        this.numberVotes = numberVotes++;
    }

    @Override
    public String toString() {

        return "У жанра " + name + " количество голосов: " + numberVotes;
    }
}
