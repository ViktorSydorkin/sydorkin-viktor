package com.homework4.hw_4.entity;

import com.homework4.hw_4.entity.enums.Approved;
import com.homework4.hw_4.entity.enums.Closed;
import com.homework4.hw_4.entity.enums.Ended;
import com.homework4.hw_4.entity.enums.Paid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    /**
     * Id of application in the DB
     */
    private long id;
    /**
     * Photo of the user's passport
     */
    private InputStream pass_photo;
    /**
     * State of application (Yes/No)
     *
     * @see Approved
     */
    private Approved approved;
    /**
     * State of application (Closed/Opened)
     *
     * @see Closed
     */
    private Closed closed;
    /**
     * State of application (Paid/Unpaid)
     *
     * @see Paid
     */
    private Paid paid;
    /**
     * State of application (Yes/No)
     *
     * @see Ended
     */
    private Ended ended;
    /**
     * User that applied for the cruise
     *
     * @see User
     */
    private User user;
    /**
     * Cruise the user applied for
     *
     * @see Cruise
     */
    private Cruise cruise;

}
