package fr.util.test;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Patch;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class TestMIDI02
{
	
	// https://www.codota.com/code/java/classes/javax.sound.midi.Sequencer
	
	public static final int NOTE_ON = 0x90;
	public static final int NOTE_OFF = 0x80;
	public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

	public static String fileIn = "C:\\Users\\emman\\eclipse-working\\in\\KOTO - Visitors.mid";
	
	public static void main(String[] args)
	{

		try
		{

			System.out.println( "Nombre d'Info : " + MidiSystem.getMidiDeviceInfo().length );
			
			for( Info info : MidiSystem.getMidiDeviceInfo() )
			{

				System.out.println( "Description : " + info.getDescription() );
				System.out.println( "Name : " + info.getName() );
				System.out.println( "Vendor : " + info.getVendor() );
				System.out.println( "Version : " + info.getVersion() );
								
				System.out.println();
				
			}
			
			Sequence sequence = MidiSystem.getSequence( new File( fileIn ) );

			System.out.println( "Nombre de patch : " + sequence.getPatchList().length );

			for( Patch patch : sequence.getPatchList() )
			{

				System.out.println( "Bank : " + patch.getBank() );
				System.out.println( "Program : " + patch.getProgram() );

				System.out.println();

			}
			
			int trackNumber = 0;

			for (Track track :  sequence.getTracks())
			{
				
				System.out.println( "Track " + trackNumber + ": size = " + track.size() );
				System.out.println();
				
				for (int i=0; i < track.size(); i++)
				{
					
					MidiEvent event = track.get(i);
					System.out.print("@" + event.getTick() + " ");
					MidiMessage message = event.getMessage();
										
					if (message instanceof ShortMessage)
					{
                    
						ShortMessage sm = (ShortMessage) message;
						System.out.print("Channel: " + sm.getChannel() + " ");
                    
						if (sm.getCommand() == NOTE_ON)
						{
                        
							int key = sm.getData1();
							int octave = (key / 12)-1;
							int note = key % 12;
							String noteName = NOTE_NAMES[note];
							int velocity = sm.getData2();
							System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
							
						}
						else if (sm.getCommand() == NOTE_OFF) 
						{
							
							int key = sm.getData1();
							int octave = (key / 12)-1;
							int note = key % 12;
							String noteName = NOTE_NAMES[note];
							int velocity = sm.getData2();
							System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);

						} 
						else
						{
							
							System.out.println("Command:" + sm.getCommand());
							
						}
						
					} 
					else
					{
						
						System.out.println("Other message: " + message.getClass());
						
					}

				}
				
				trackNumber++;

			}

		}
		catch (InvalidMidiDataException imde) 
		{

			System.out.println( "InvalidMidiDataException : " + imde.getMessage() );

		}
		catch (IOException ioe) 
		{

			System.out.println( "IOException : " + ioe.getMessage() );
			
		}
		
	}

}
