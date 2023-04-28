/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formularios;

/**
 *
 * @author juanfelipepipen
 */
public class SheetExtractModel {
    public double id = 0f;
    public String name = "";

    public String getId() {
        Double d = Double.valueOf(id);
        return "00000" + d.intValue();
    }
}
