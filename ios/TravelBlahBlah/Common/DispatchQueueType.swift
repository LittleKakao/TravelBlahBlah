//
//  DispatchQueueType.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/17/24.
//

import Foundation

protocol DispatchQueueType {
    func async(execute work: @escaping () -> Void)
}

extension DispatchQueue: DispatchQueueType {
    func async(execute work: @escaping () -> Void) {
        async(group: nil, execute: work)
    }
}
