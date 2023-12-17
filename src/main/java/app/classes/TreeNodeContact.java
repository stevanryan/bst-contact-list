package app.classes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNodeContact {
    private Contact value;
    private TreeNodeContact leftNode;
    private TreeNodeContact rightNode;
    private int height;

    public TreeNodeContact (Contact node) {
        this.value = node;
        this.leftNode = null;
        this.rightNode = null;
    }
}
