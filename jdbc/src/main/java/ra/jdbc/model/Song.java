package ra.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    public Object setDescription;
    private Integer id;
    private String songname,author,description,imageUrl,videoUrl;
    private int duration;
    private  boolean status;

}
