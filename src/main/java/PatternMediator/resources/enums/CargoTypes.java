/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.enums;

/**
 *
 * @author comrade
 */
public enum CargoTypes {

    Living(4),
    Perishable(3),
    Danger(2),
    Default(1);

    private Integer priority;

    public Integer getPriority() {
        return this.priority;
    }

    CargoTypes(Integer priority) {
        this.priority = priority;
    }
}
