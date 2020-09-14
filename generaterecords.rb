puts "INSERT INTO Items (ITEM_ID, DESCRIPTION, INVENTORY_STATUS) VALUES"
99.times do |i|
    puts "   ('%s', '%s', 0)," % ["Item_id" + i.to_s, "Item_description" + i.to_s]
end
puts "   ('XXX', 'last book', 0);"
