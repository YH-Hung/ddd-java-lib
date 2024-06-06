# Mapping Table

(RulePropertyName, PropOrAttr, MaskInfoName, TopOrListName)

# PropertyDescriptor

- Prop, Top: pd -> getter -> invoke
- Prop, List: pd -> getter -> invoke / list contains with override equal
- Attr, Top:  filter by name -> getVal / pd -> getter -> invoke
- Attr, List: filter by name -> getVal / list contains with override equal