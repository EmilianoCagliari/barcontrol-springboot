package egcdev.barcontrol.model.entity.enums;

public enum Roles {

    User(1), Admin(2);

    private Integer value;
    private Roles( int value ) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }
}
