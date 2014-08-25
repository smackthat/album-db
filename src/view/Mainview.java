package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import fi.jyu.mit.gui.StringTable;

import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

import model.Levy;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

import controller.LevyHallinnoija;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;


/**
 * Ohjelman pääikkuna. Tästä käyttäjä ohjaa kaikkea, teen siitä nätin näköisen :-)
 * @author Johannes Stenberg
 * @since 10.08.2014
 * @version 18.08.2014
 */
public class Mainview extends JFrame {

	/**
	 * Derp.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField artistSrchTxt;
	private JTextField textField;
	
	protected static final LevyHallinnoija hal = new LevyHallinnoija();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainview frame = new Mainview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainview() {
		setResizable(false);
		setTitle("MinRawr's Albums");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 455);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnAlbums = new JMenu("Data");
		menuBar.add(mnAlbums);
				
						JMenuItem mntmMyWishlist = new JMenuItem("Wishlist");
						mnAlbums.add(mntmMyWishlist);
		
				JMenuItem mntmMyCollection = new JMenuItem("Collection");
				mnAlbums.add(mntmMyCollection);
				
						JMenuItem mntmStatistics = new JMenuItem("Statistics");
						mnAlbums.add(mntmStatistics);

		JMenu mnSearch = new JMenu("Search...");
		mnSearch.setActionCommand("Search...");
		menuBar.add(mnSearch);

		JMenu mnArtist = new JMenu("Artist...");
		mnSearch.add(mnArtist);

		artistSrchTxt = new JTextField();
		mnArtist.add(artistSrchTxt);
		artistSrchTxt.setColumns(12);

		JMenu mnAlbum = new JMenu("Album...");
		mnSearch.add(mnAlbum);

		textField = new JTextField();
		mnAlbum.add(textField);
		textField.setColumns(12);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel tablePanel = new JPanel();
		tablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(tablePanel, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);


		/**
		 * Taulu, johon kaikki levyt tulevat.
		 */
		final StringTable stringTable = new StringTable();
		stringTable.setToolTipText("Collection");
		stringTable.getTable().setRowSelectionAllowed(false);
		stringTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stringTable.setPreferredSize(new Dimension(470, 359));
		stringTable.getTable().setModel(new DefaultTableModel(
				new Levy[][] {
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
				},
				new String[] {
						"Artist", "Album", "Year", "Format", "Label"
				}
				));
		stringTable.getScrollPane().setPreferredSize(new Dimension(454, 330));
		stringTable.setMinimumSize(new Dimension(25, 10));


		/*Kuuntelija klikkauksille.
		 * 
		 */
		stringTable.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int lkm = stringTable.getTable().getSelectedColumn();
				JOptionPane.showMessageDialog(null, lkm);

			}
		});
		tablePanel.add(stringTable);

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(null);
		dataPanel.setPreferredSize(new Dimension(250, 10));
		dataPanel.setBackground(SystemColor.menu);
		dataPanel.setMinimumSize(new Dimension(1000, 10));
		contentPane.add(dataPanel, BorderLayout.WEST);
		dataPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(upperPanel, BorderLayout.NORTH);
		
		JLabel lblCollection = new JLabel("Collection");
		upperPanel.add(lblCollection);
	}

}
