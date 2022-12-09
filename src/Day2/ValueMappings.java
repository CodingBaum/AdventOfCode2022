package Day2;

public class ValueMappings {
    private int value;
    private int better;
    private int worse;

    public ValueMappings(int value) {
        this.value = value;

        switch (value) {
            case 1 -> {
                this.better = 2;
                this.worse = 3;
            }
            case 2 -> {
                this.better = 3;
                this.worse = 1;
            }
            case 3 -> {
                this.better = 1;
                this.worse = 2;
            }
        }
    }

    public int getValue() {
        return value;
    }

    public int better() {
        return better;
    }

    public int worse() {
        return worse;
    }
}
