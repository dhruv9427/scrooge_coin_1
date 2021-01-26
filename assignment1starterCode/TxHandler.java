import org.omg.CORBA.PUBLIC_MEMBER;

import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.util.ArrayList;

public class TxHandler {

    public UTXOPool uPool;
    public UTXO utxo;
    public Transaction tx1;
    public Crypto crypto;
    public PublicKey pk;
    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */

    public TxHandler(UTXOPool utxoPool) {
        utxoPool = this.uPool;
        isValidTx(tx1);
        handleTxs(tx1[]);
    }

    /**
     * @return true if:
     * (1) all outputs claimed by {@code tx} are in the current UTXO pool, 
     * (2) the signatures on each input of {@code tx} are valid, 
     * (3) no UTXO is claimed multiple times by {@code tx},
     * (4) all of {@code tx}s output values are non-negative, and
     * (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
     *     values; and false otherwise.
     */
    public boolean isValidTx(Transaction tx) {
        ArrayList<Transaction.Output> outData = new ArrayList<Transaction.Output>();
        ArrayList<Transaction.Input> inData = new ArrayList<Transaction.Input>();
        ArrayList<Byte> msg = new ArrayList<Byte>();

        for (int i = 0;i < tx.numOutputs();i++)
        {
            tx.getInput(i);
            tx.getOutput(i);
            outData.add(tx.getOutput(i));
            inData.add(tx.getInput(i));
        }

        if (crypto.verifySignature() == true && tx.numOutputs() > 0 && outData.size() ==  inData.size() && outData == inData)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
        // IMPLEMENT THIS
    }

}
