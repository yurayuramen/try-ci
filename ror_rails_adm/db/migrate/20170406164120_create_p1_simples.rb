class CreateP1Simples < ActiveRecord::Migration[5.0]
  def change
    create_table :p1_simples do |t|

      t.timestamps
    end
  end
end
