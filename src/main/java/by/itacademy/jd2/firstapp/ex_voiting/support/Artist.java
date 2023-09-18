package by.itacademy.jd2.firstapp.ex_voiting.support;

public class Artist {

    private String name;
    private int numberVotes;

    public Artist(String name) {

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
        return "У " + name + " количество голосов: " + numberVotes;
    }
}


