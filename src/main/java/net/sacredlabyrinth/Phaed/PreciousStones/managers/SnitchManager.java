package net.sacredlabyrinth.Phaed.PreciousStones.managers;

import net.sacredlabyrinth.Phaed.PreciousStones.FieldFlag;
import net.sacredlabyrinth.Phaed.PreciousStones.Helper;
import net.sacredlabyrinth.Phaed.PreciousStones.PreciousStones;
import net.sacredlabyrinth.Phaed.PreciousStones.entries.SnitchEntry;
import net.sacredlabyrinth.Phaed.PreciousStones.vectors.Field;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author phaed
 */
public class SnitchManager
{
    private PreciousStones plugin;

    /**
     *
     */
    public SnitchManager()
    {
        plugin = PreciousStones.getInstance();
    }

    /**
     * @param player
     * @param entity
     */
    public void recordSnitchEntityKill(Player player, Entity entity)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(entity.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Kill", entity.getType().getName(), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param victim
     */
    public void recordSnitchPlayerKill(Player player, Player victim)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(victim.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Kill", victim.getName(), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param field
     */
    public void recordSnitchEntry(Player player, Field field)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            if (FieldFlag.SNITCH.applies(field, player))
            {
                DateFormat dateFormat = new SimpleDateFormat("MMM d, h:mm a z");
                plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Entry", dateFormat.format(new Date()), 1));
            }
        }

    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchBlockBreak(Player player, Block block)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Block Break", toBlockDetails(block), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchBucketEmpty(Player player, Block block, String type)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    String details = Helper.friendlyBlockType(type) + " [" + block.getLocation().getBlockX() + " " + block.getLocation().getBlockY() + " " + block.getLocation().getBlockZ() + "]";

                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Bucket Empty", details, 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchBucketFill(Player player, Block block)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Bucket Filled", toBlockDetails(block), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchBlockPlace(Player player, Block block)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Block Place", toBlockDetails(block), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchUsed(Player player, Block block)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Used", toBlockDetails(block), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchShop(Player player, Block block)
    {
        Sign sign = (Sign) block.getState();

        if (sign.getLines().length == 0)
        {
            return;
        }

        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Shopped", toBlockDetails(block), 1));
                }
            }
        }
    }

    /**
     * @param player
     * @param block
     */
    public void recordSnitchIgnite(Player player, Block block)
    {
        if (!plugin.getPermissionsManager().has(player, "preciousstones.bypass.snitch"))
        {
            List<Field> snitchFields = plugin.getForceFieldManager().getEnabledSourceFields(block.getLocation(), FieldFlag.SNITCH);

            for (Field field : snitchFields)
            {
                if (FieldFlag.SNITCH.applies(field, player))
                {
                    plugin.getStorageManager().offerSnitchEntry(new SnitchEntry(field, player.getName(), "Ignite", toBlockDetails(block), 1));
                }
            }
        }
    }

    /**
     * Returns formatted coordinates
     *
     * @param block
     * @return
     */
    public static String toBlockDetails(Block block)
    {
        return Helper.friendlyBlockType(block.getType().toString()) + " [" + block.getLocation().getBlockX() + " " + block.getLocation().getBlockY() + " " + block.getLocation().getBlockZ() + "]";
    }
}
