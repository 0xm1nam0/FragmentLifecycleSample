package com.example.wagatsumakenju.fragmentlifecyclesample;

import android.os.Handler;
import android.os.Message;

import java.util.Vector;

/**
 * ClassComments
 *
 * @author Kenju Wagatsuma
 */
public abstract class PauseHandler extends Handler {
    /**
     * Message Queue Buffer
     */
    final Vector<Message> messageQueueBuffer = new Vector<Message>();

    /**
     * Flag indicating the pause state
     */
    private boolean paused;

    /**
     * Resume the handler
     */
    final public void resume() {
        paused = false;

        while (messageQueueBuffer.size() > 0) {
            final Message msg = messageQueueBuffer.elementAt(0);
            messageQueueBuffer.removeElementAt(0);
            sendMessage(msg);
        }
    }

    /**
     * Pause the handler
     */
    final public void pause() {
        paused = true;
    }

    /**
     * Notification that the message is about to be stored as the activity is
     * paused. If not handled the message will be saved and replayed when the
     * activity resumes.
     *
     * @param message the message which optional can be handler
     * @return true if the message is to be stored
     */
    protected abstract boolean storeMessage(Message message);

    
}
