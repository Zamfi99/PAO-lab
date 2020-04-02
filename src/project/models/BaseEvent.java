package pao.tickets.models;

public class BaseEvent {
    protected Integer _ids = 0;
    protected Integer id;

    public BaseEvent() {
        this._ids += 1;
        this.id = this._ids;
    }

    public Integer getId() {
        return id;
    }
}
