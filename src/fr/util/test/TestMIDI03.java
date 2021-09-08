package fr.util.test;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Patch;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;

public class TestMIDI03
{

	public static void main(String[] args)
	{

		try
		{

			// Create a synthesizer
		    Synthesizer synthesizer = MidiSystem.getSynthesizer();
		    synthesizer.open();
		    
			// Create a sequencer
		    Sequencer sequencer = MidiSystem.getSequencer();
		    sequencer.open();

		    
		    
			// Create a sequence		    

		    Sequence sequence = new Sequence(Sequence.PPQ, 1);
		    Track track = sequence.createTrack();
		    
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_ON, 0, 60, 127), 0 ) );
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_OFF, 0, 60, 100), 1 ) );

		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_ON, 0, 60, 100), 1 ) );
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_OFF, 0, 60, 100), 2 ) );

		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_ON, 0, 60, 100), 2 ) );
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_OFF, 0, 60, 100), 3 ) );
		    
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_ON, 0, 62, 100), 3 ) );
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_OFF, 0, 62, 100), 4 ) );

		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_ON, 0, 64, 100), 4 ) );
		    track.add( new MidiEvent( new ShortMessage( ShortMessage.NOTE_OFF, 0, 64, 100), 5 ) );

		    
		    sequencer.setSequence(sequence);

		    // Start playing
		    sequencer.start();
		
		}
		catch (InvalidMidiDataException imde) 
		{
			
			System.out.println( "InvalidMidiDataException : " + imde.getMessage() );
		}
		catch (MidiUnavailableException mue) 
		{
			
			System.out.println( "MidiUnavailableException : " + mue.getMessage() );
		}

	}

}
