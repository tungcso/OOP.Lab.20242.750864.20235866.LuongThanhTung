package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.playable.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            
              ButtonListener btnListener = new ButtonListener();
            playButton.addActionListener(btnListener);
            
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
    }
    private class ButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
        	createPlayDialog();
        }
        }
    private void createPlayDialog() {
        JDialog playDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Playing: " + media.getTitle(), true);
        JPanel dialogPanel = new JPanel();

        if (media instanceof Playable) {
            ((Playable) media).play(); // Call the play method
            dialogPanel.add(new JLabel("Playing: " + media.getTitle()));
            dialogPanel.add(new JLabel("\nLength: " + media.getLength()));
        } else {
            dialogPanel.add(new JLabel("Cannot play: " + media.getTitle()));
        }

        playDialog.add(dialogPanel);
        playDialog.setSize(200, 150);
        playDialog.setLocationRelativeTo(this);
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        playDialog.setVisible(true);
    }
}