pe6  0System.Activities.Presentation.View.DesignerView:	  4System.Activities.Presentation.WorkflowItemPresenter 	 Name 	  IsDefaultContainer  	  AllowedItemType 
   System.Activities.Activity  dropActivityHint! 	  HintText" 	  Item# �� Mode$ J� SnapsToDevicePixels " WorkflowViewElementBorderBrush  CatchesTemplate;  5System.Activities.Presentation.WorkflowItemsPresenter%  Name&   AllowedItemType(   "System.Activities.Statements.Catch'   SpacerTemplate(   Items) �� Orientation7  1System.Activities.Presentation.View.TypePresenter'*    CenterActivityTypeResolverDialog+   Context  FinallyTemplate 	 ExpandedTryCatchTemplate 
 TryCatchStyle ! CollapsedActivityViewTemplate�� ResourceDictionary_1��   +'sad:CachedResourceDictionaryExtension_1��$� �pack://application:,,,/System.Activities.Core.Presentation;component/System/Activities/Core/Presentation/Themes/DesignerStyleDictionary.xaml?�  +'sad:CachedResourceDictionaryExtension_2��$Y Spack://application:,,,/System.Activities.Presentation;component/Themes/Generic.xaml?�  +'sad:CachedResourceDictionaryExtension_3��$x rpack://application:,,,/System.Activities.Presentation;component/System/Activities/Presentation/ColorResources.xaml?�%  &	        &	      &	 =     &	 Z     7  7  7  7  &	 �    7  7   7   7  &	 �    7  7  7  &		 �    7  7  7  &	
 z      NotConverter_1��  HintTextMaxWidthConverter_1��  HintTextConverter_1���� DataTemplate_1��.R��� StackPanel_1��.+��� Border_1��$��1q�$��0,15,0,2q�$ 0q����� Style_1��.��� Setter_1�� � ��8    �� DataTrigger_1�� �� $	 ShowTryExpanded�$

 true��.a��� Setter_2�� � �� �� LinearGradientBrush_1��$ 	0.504,1.5&�$ 
0.504,0.03&�.��� GradientStop_1��# Z $	 0.5Q�� GradientStop_2��# Z $ 0Q��� Setter_3�� � ��$ 
-3,-3,-3,0q�._��� -   StackPanel_2�����	#00FFFFFF . |�. .+�� 
Grid_2�� �� ColumnDefinition_1���� ColumnDefinition_2��.+��� Label_1��$��0��$ TryLabel��$ Probar��$��Center=�$��0,3,7,1q�|�. $��0q�$��0q�$
��Bold"�.��Try�� TextBlock_1��$��1��#��Z
�$��Italic$�$��Center=�$��Right=�$��5,3,3,0q�$��CharacterEllipsis=����� $	 ModelItem.Try�$ controlRoot��8  $	 150�� �� *Text+# Z ��`� MultiBinding_1��8  .1��� 	Binding_1��$	 ModelItem.Try��� 	Binding_2��$	 ModelItem.Try.DisplayName����� Style_8��" ��.��� 	Setter_21�� � y�$ Visible=� �� DataTrigger_11�� �� $	 ShowTryExpanded�$

 true��.a��� 	Setter_22�� � y�$ 	Collapsed=��� DataTrigger_12�� ��  �� "  $	 ShouldExpandAll�$

 true��.a��� 	Setter_23�� � y�$ 	Collapsed=�	  $ tryPresenter��tryPresenter�� . $	 Try��"  
 #! �  $	��400��$	��100��$��1,1,1,3q�$% Try: coloque la actividad aquí��" �� $	 ModelItem.Try�$# TwoWay=����� Style_2��" 	 .��� Setter_4�� � y�$ 	Collapsed=� �� DataTrigger_2�� �� $	 ShowTryExpanded�$

 true��.a��� Setter_5�� � y�$ Visible=��� DataTrigger_3�� ��  �� "  $	 ShouldExpandAll�$

 true��.a�