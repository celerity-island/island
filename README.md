# island

Ideas:

1) Create Tools, extending Item.
2) Reformat Item into abstract class. 
3) Remove "consume" from Item. Develop functional interface Consumable with "consume" method. Implement Consumable in Materials.
	- For countable items, it will decrase the quantity of items by the given amount. For other items, it will remove the item from inventory.

4) Develop "Processable" functional interface. Implement Processable in Tools. Develop "process" method.
	- For example, building for hammers, gathering for axes

5) Add items as Tools types:
	- Hammer(tools), using for build a house.
	- Axe(tools), using for gathering materials.

6) Develop upgrades for tools, improving gathering amount for Axes (or all gatherable items), and time consumed for Hammers (or all buildable items)
