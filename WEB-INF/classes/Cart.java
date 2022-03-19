package cart;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;

public class Cart {
    private Vector<CartItem> cartItems;

    public Cart() {
        cartItems = new Vector<>();
    }

    public void addCartItem(final CartItem cartItem) {
        if (cartItems.contains(cartItem)) {
            int index = cartItems.indexOf(cartItem);
            CartItem thisCartItem = (CartItem) cartItems.get(index);
            thisCartItem.setQuantity(thisCartItem.getQuantity() + 1);
        } else {
            cartItems.addElement(cartItem);
        }
    }

    public void removeCartItem(final CartItem cartItem) {
        cartItems.remove(cartItem);
    }

    public Collection<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(final Vector<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getCartValue() {
        double value = 0;
        Enumeration<CartItem> en = cartItems.elements();
        while (en.hasMoreElements()) {
            CartItem cartItem = (CartItem) en.nextElement();
            value += (cartItem.getItem().getPrice() * cartItem.getQuantity());
        }
        return value;
    }
}